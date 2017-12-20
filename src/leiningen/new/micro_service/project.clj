(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [commons-daemon/commons-daemon "1.0.15"]
                 [ring "1.4.0"]
                 [ring-json-response "0.2.0"]
                 [ring/ring-defaults "0.1.5"]
                 [compojure "1.5.0"]
                 [org.danielsz/system "0.4.0"]
                 [environ "1.0.0"]]
  :plugins [[lein-environ "1.0.0"]]
  :uberjar-name "{{ns-name}}.jar"
  :profiles {:dev {:source-paths ["dev"]
                   :env {:http-port 3000}}
             :uberjar {:source-paths ^:replace ["src/"]
                       :hooks []
                       :main {{ns-name}}.daemon
                       :omit-source true
                       :aot :all}}
  :target-path "target/%s")
