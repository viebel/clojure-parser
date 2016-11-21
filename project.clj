(defproject org.clojure/tools.reader "1.0.0-SNAPSHOT"
  :description "A Clojure reader in Clojure"
  :parent [org.clojure/pom.contrib "0.1.2"]
  :url "https://github.com/clojure/tools.reader"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/main/clojure" "src/main/cljs"]
  :test-paths ["src/test/clojure"]
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.293" :scope "provided"]]
  :min-lein-version "2.0.0"
  :global-vars {*warn-on-reflection* true
                *unchecked-math* :warn-on-boxed}
  :plugins [[lein-doo "0.1.6"]
            [lein-cljsbuild "1.1.1"]]
  :cljsbuild
  {:builds [{:id "dev"
             :source-paths ["src/main/cljs"]
             :compiler {:output-to "out/main.js"
                        :output-dir "out"
                        :optimizations :simple
                        :pretty-print true}}
            {:id "whitespace"
             :source-paths ["src/main/cljs" "src/test/cljs"]
             :compiler {:output-to "target/test/tests-whitespace.js"
                        :output-dir "target/test/out-whitespace"
                        :optimizations :whitespace}}
            {:id "simple"
             :source-paths ["src/main/cljs" "src/test/cljs"]
             :notify-command ["node" "target/test/tests-simple.js"]
             :compiler {:optimizations :simple
                        :output-to "target/test/tests-simple.js"
                        :output-dir "target/test/out-simple"}}
            {:id "advanced"
             :source-paths ["src/main/cljs" "src/test/cljs"]
             :compiler {:optimizations :advanced
                        :output-to "target/test/tests-advanced.js"
                        :output-dir "target/test/out-advanced"}}]
   :test-commands
   {"simple" ["node" "target/test/tests-simple.js"]
    "advanced" ["node" "target/test/tests-advanced.js"]}})
