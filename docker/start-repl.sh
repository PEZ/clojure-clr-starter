#!/bin/bash

source /app/dependencies/load-path.sh

cleanup() {
  rm -f /app/docker/.nrepl-port
}
trap cleanup EXIT

Clojure.Main -e '(require (quote user)) (user/start-nrepl!)'
