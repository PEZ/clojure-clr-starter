(ns user
  (:require [clojure.tools.nrepl]))

(defn start-nrepl! []
  (clojure.tools.nrepl/start-server! {:host "dotnet-clojure"
                                      :port 1667
                                      :quiet true})
  (spit "docker/.nrepl-port" "6667")
  (println "Started nREPL server at localhost:6667"))

(comment
  (start-nrepl!)
  :rcf)

