FROM mcr.microsoft.com/dotnet/sdk

# Install required packages
RUN apt-get update \
    && apt-get install -y wget unzip curl default-jre rlwrap \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Install ClojureCLR
RUN dotnet tool install --global --version 1.12.0-alpha7 Clojure.Main

# Babashka gives us tools.deps power
RUN curl -sLO https://raw.githubusercontent.com/babashka/babashka/master/install \
    && chmod +x install \
    && ./install

ENV PATH="${PATH}:/root/.dotnet/tools"

# The entrypoint runs our deps el cheapo script
ENTRYPOINT ["/app/docker/entrypoint.sh"]

CMD ["/app/docker/keepalive.sh"]
