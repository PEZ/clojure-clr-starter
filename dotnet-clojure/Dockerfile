FROM mcr.microsoft.com/dotnet/sdk

RUN apt-get update \
    && apt-get install -y wget unzip psutils

RUN dotnet tool install --global --version 1.12.0-alpha7 Clojure.Main

RUN apt-get clean \
    && rm -rf /var/lib/apt/lists/*

CMD ["/root/.dotnet/tools/Clojure.Main"]