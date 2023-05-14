#!/usr/bin/env bb

(require '[clojure.string :as string])
(require '[clojure.edn :as edn])
(require '[babashka.deps :as deps])
(require '[babashka.classpath :as classpath])
(require '[babashka.fs :as fs])

(defn process-classpath [classpath]
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
       (string/join ":")))

(when (= *file* (System/getProperty "babashka.file"))
  (deps/add-deps (edn/read-string (slurp "deps.edn")) {:aliases [:dev]})
  (-> (classpath/get-classpath)
      process-classpath
      println))
