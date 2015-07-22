(defproject algorithm-clj "0.1.0-SNAPSHOT"
  :description "practice algorithm by clj"
  :url "https://github.com/idkkk/algorithm/tree/master/code/clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot algorithm-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})