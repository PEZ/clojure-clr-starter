FROM mcr.microsoft.com/dotnet/sdk

# Install required packages
RUN apt-get update \
    && apt-get install -y wget unzip curl default-jre

# Install ClojureCLR
RUN dotnet tool install --global --version 1.12.0-alpha7 Clojure.Main

# Install Leiningen
ENV LEIN_ROOT=1
ENV LEIN_VERSION=2.9.7
RUN curl -L -o /usr/local/bin/lein "https://raw.githubusercontent.com/technomancy/leiningen/${LEIN_VERSION}/bin/lein" \
    && chmod +x /usr/local/bin/lein \
    && lein upgrade

# Clean up apt stuff
RUN apt-get clean \
    && rm -rf /var/lib/apt/lists/*

ENV PATH="${PATH}:/root/.dotnet/tools"

# Entrypoint and dependencies el cheapo
#COPY entrypoint.sh /entrypoint.sh
#COPY cheap-deps.sh /cheap-deps.sh
#RUN chmod +x /cheap-deps.sh
ENTRYPOINT ["/app/docker/entrypoint.sh"]


# Keep container running
CMD ["tail", "-f", "/dev/null"]
