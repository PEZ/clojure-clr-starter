(defproject clojure-clr-test "0.1.0-SNAPSHOT"
  :description "A sample ClojureCLR project"
  :url "https://github.com/PEZ/clojure-clr-test"
  :license "MIT"
  :dependencies [[org.clojure.clr/tools.nrepl "0.1.0-alpha1"]]
  :min-lein-version "2.0.0"
  :plugins [[lein-clr "0.2.0"]]
  :source-paths ["src"]
  :resource-paths ["resources"]
  :main pez.hello
  :main-cmd [:clj-exe "Clojure.Main" "-e" "'(require '[clojure.tools.nrepl]) (clojure.tools.nrepl/start-server!)'"])