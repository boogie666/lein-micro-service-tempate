(ns {{ns-name}}.systems
  (:require [system.core :refer [defsystem]]
            [com.stuartsierra.component :as component]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json-response :refer [wrap-json-response]]
            (system.components
              [endpoint :refer [new-endpoint]]
              [handler :refer [new-handler]]
              [middleware :refer [new-middleware]]
              [jetty :refer [new-web-server]])
            [environ.core :refer [env]]
            [{{ns-name}}.handler :refer [app-routes]]))


(defn config []
  {:http {:port (Integer. (env :http-port))}})

(defn system []
  (let [cfg (config)]
    (component/system-map
     :middleware (new-middleware {:middleware [wrap-json-response
                                               [wrap-defaults api-defaults]]})
     :routes     (new-endpoint #'app-routes)
     :handler    (-> (new-handler)
                     (component/using [:routes :middleware]))
     :web        (-> (new-web-server (-> cfg :http :port))
                     (component/using [:handler])))))

