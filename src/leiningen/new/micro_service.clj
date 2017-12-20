(ns leiningen.new.micro-service
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "micro-service"))

(defn micro-service
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data
            ["src/{{sanitized}}/systems.clj" (render "src/micro_service/systems.clj" data)]
            ["src/{{sanitized}}/handler.clj" (render "src/micro_service/handler.clj" data)]
            ["dev/user.clj" (render "dev/user.clj" data)]
            ["src/{{sanitized}}/daemon.clj" (render "src/micro_service/daemon.clj" data)]
            ["scripts/build.sh" (render "scripts/build.sh" data)]
            ["scripts/start.sh" (render "scripts/start.sh" data)]
            ["scripts/stop.sh" (render "scripts/stop.sh" data)]
            ["project.clj" (render "project.clj" data)]
            ["README.md" (render "README.md" data)]
            ["test/{{sanitized}}/core_test.clj" (render "test/micro_service/core_test.clj" data)]
            ["resources/.gitkeep" (render "resources/.gitkeep")])))
