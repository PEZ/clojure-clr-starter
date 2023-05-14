#!/bin/bash

mkdir -p /app/dependencies
CLOJURE_LOAD_PATH=$(/app/docker/cheap-deps.sh)
echo "export CLOJURE_LOAD_PATH=${CLOJURE_LOAD_PATH}" > /app/dependencies/load-path.sh

exec "$@"
