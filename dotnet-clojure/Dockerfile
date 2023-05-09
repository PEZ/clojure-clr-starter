FROM mcr.microsoft.com/dotnet/sdk

RUN apt-get update \
    && apt-get install -y wget unzip

RUN dotnet tool install --global Clojure.Main

RUN apt-get clean \
    && rm -rf /var/lib/apt/lists/*

CMD ["Clojure.Main"]
