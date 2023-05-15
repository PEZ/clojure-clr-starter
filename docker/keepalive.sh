#!/bin/bash

cleanup() {
  echo "Removing docker/.nrepl-port ..." >&2
  rm -f /app/docker/.nrepl-port
}
trap cleanup EXIT

echo "Keeping the container running ..." >&2

tail -f /dev/null