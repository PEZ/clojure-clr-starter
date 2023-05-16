#!/usr/bin/env bb

(require '[clojure.string :as string])
(require '[clojure.edn :as edn])
(require '[babashka.deps :as deps])
(require '[babashka.classpath :as classpath])
(require '[babashka.fs :as fs])
(require '[babashka.cli :as cli])

(defn process-jar-deps! [classpath]
  (->> classpath 
       classpath/split-classpath
       (map (fn [path]
              (if (clojure.string/ends-with? path ".jar")
                (let [deps-subdir (string/replace (fs/file-name path) #".jar$" "")
                      deps-dir (str "/app/dependencies/" deps-subdir)]
                  (fs/create-dirs deps-dir)
                  (fs/unzip path deps-dir {:replace-existing true})
                  deps-dir)
                path)))
       (string/join fs/path-separator)))

(when (= *file* (System/getProperty "babashka.file"))
  (let [aliases (:alias (cli/parse-opts *command-line-args* {:spec {:alias {:alias :a
                                                                            :default [:dev]
                                                                            :coerce [:keyword]}}}))]
    (deps/add-deps (edn/read-string (slurp "deps.edn")) {:aliases aliases})
    (-> (classpath/get-classpath)
        process-jar-deps!
        println)))
