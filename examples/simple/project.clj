

(defproject simple-cloact "0.1.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [cloact "0.1.0"]]
  :plugins [[lein-cljsbuild "1.0.1"]]
  :hooks [leiningen.cljsbuild]
  :profiles {:prod {:cljsbuild
                    {:builds
                     {:client {:compiler
                               {:optimizations :advanced
                                :preamble ^:replace ["cloact/react.min.js"]
                                :pretty-print false}}}}}
             :srcmap {:cljsbuild
                      {:builds
                       {:client {:compiler
                                 {:source-map "target/client.js.map"
                                  :source-map-path "client"}}}}}}
  :source-paths ["src"]
  :cljsbuild
  {:builds
   {:client {:source-paths ["src"]
             :compiler
             {:preamble ["cloact/react.js"]
              :output-dir "target/client"
              :output-to "target/client.js"
              :pretty-print true}}}})
