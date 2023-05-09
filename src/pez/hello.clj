(ns pez.hello
  (:require [pez.utils :as utils]
            [clojure.tools.nrepl]))

(defn hello-world []
  (println "Hello, World!"))

(defn main [& args]
  (hello-world)
  (println (utils/square 5)))

;; This probably won't work, but hey
(clojure.tools.nrepl/start-server!)