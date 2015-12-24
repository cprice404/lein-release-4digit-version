(ns release-4digit-version.plugin
  (:require [robert.hooke :as hooke]
            [leiningen.release]
            [leiningen.release-4digit-version]))

(defn hooks
  [& args]
  (hooke/add-hook #'leiningen.release/bump-version
                  #'leiningen.release-4digit-version/wrap-with-4d-bump-version))
