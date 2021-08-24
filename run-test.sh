#!/bin/sh
docker build -t keyhoh/business docker/unit-test/
docker run --mount type=bind,source="$(pwd)",target=/app -t keyhoh/business:latest
