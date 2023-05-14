FROM mcr.microsoft.com/dotnet/sdk

# Install required packages
RUN apt-get update \
    && apt-get install -y wget unzip curl default-jre rlwrap \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Install ClojureCLR
RUN dotnet tool install --global --version 1.12.0-alpha7 Clojure.Main

# Install Clojure CLI
ENV CLOJURE_VERSION=1.11.1.1273
RUN curl -O "https://download.clojure.org/install/linux-install-${CLOJURE_VERSION}.sh" \
    && chmod +x "linux-install-${CLOJURE_VERSION}.sh" \
    && "./linux-install-${CLOJURE_VERSION}.sh"
ENV PATH="${PATH}:/root/.dotnet/tools"

# The entrypoint runs our deps el cheapo script
ENTRYPOINT ["/app/docker/entrypoint.sh"]

# Keep container running
CMD ["tail", "-f", "/dev/null"]
