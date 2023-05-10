(ns pez.hello
  (:require [pez.utils :as utils]))

(defn hello-world []
  (println "Hello, World!"))

(defn main [& args]
  (hello-world)
  (println (utils/square 5)))
