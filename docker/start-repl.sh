#!/bin/bash

source /app/dependencies/load-path.sh
echo "Exported CLOJURE_LOAD_PATH: ${CLOJURE_LOAD_PATH}" >&2

cleanup() {
  echo "Removing docker/.nrepl-port ..." >&2
  rm -f /app/docker/.nrepl-port
}
trap cleanup SIGINT SIGTERM

Clojure.Main -e '(require (quote user)) (user/start-nrepl!)'
