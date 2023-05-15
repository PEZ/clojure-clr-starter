#!/bin/bash

source /app/dependencies/load-path.sh
echo "Loaded CLOJURE_LOAD_PATH: ${CLOJURE_LOAD_PATH}" >&2

cleanup() {
  rm -f /app/docker/.nrepl-port
}
trap cleanup EXIT

Clojure.Main -e '(require (quote user)) (user/start-nrepl!)'
