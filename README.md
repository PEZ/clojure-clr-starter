# A Dockerized CLojureCLR Starter Project

Powered by [clr.tools.nrepl](https://github.com/clojure/clr.tools.nrepl)

Do you want to try [ClojureCLR](https://github.com/clojure/clojure-clr) out quickly and easily in your Clojure editor of choice? Then this mini-project might be for you.

## Prerequisites

1. You have Docker installed
2. You have a Clojure editor that can connect to an [nREPL](https://nrepl.org/) server
3. You know some Clojure and how to connect your editor to a REPL

If you don't ”know some Clojure”, please see: https://calva.io/get-started-with-clojure/

## Preparation

1. Fork or make a copy of this repository
2. Clone to your computer
3. From a terminal in the project root:
    ```sh
    docker compose build
    docker compose up -d
    ```

This will create and start the Docker composition consisting of one service named `dotnet-clojure`. This is where we will start the project and its nREPL server.

## Start the REPL and Connect your Editor

### If you are using [Calva](https://calva.io)

You can now start the project REPL and connect it with the command **Calva: Start a Project REPL and Connect (a.k.a.Jack-in)**, <kbd>ctrl</kbd>+<kbd>alt</kbd>+<kbd>c</kbd> <kbd>ctrl</kbd>+<kbd>alt</kbd>+<kbd>j</kbd>

You can also choose to start the REPL manually (as per [below](#start-the-repl)) and use the command **Calva: Connect to a Running REPL in your Project**, <kbd>ctrl</kbd>+<kbd>alt</kbd>+<kbd>c</kbd> <kbd>ctrl</kbd>+<kbd>alt</kbd>+<kbd>c</kbd>
This has the benefit that the REPL will keep running in the docker container when you close the project, and Calva will reconnect it automatically whenever you open the project.

If you are using some other editor, please read on.

### Start the REPL

From a terminal in the project root:

```sh
docker compose exec -it dotnet-clojure /app/docker/start-repl.sh
```

### Connect your Editor

When the command above prints:

```
Started nREPL server at localhost:6667
```

you can connect your editor to the REPL and hack away.

## Restarting the REPL

The way that the REPL is run with this setup, it will continue to run until you kill it inside the docker container (or maybe it crashes for some reason). Depending on your Docker fu, you can restart the REPL in there, or you can simply restart the container:

```sh
docker compose down
docker compose up -d
```

Then [Start the REPL](#start-the-repl-and-connect-your-editor) again.

## Running the example app

If you want to run the example app from the command line, without involving a REPL, you can do so by calling `Clojure.Main -m starter.hello`. You will need to populate the `CLOJURE_LOAD_PATH`. 

```sh
$ docker-compose exec -e CLOJURE_LOAD_PATH=src dotnet-clojure Clojure.Main -m starter.hello
```

If you have .Net and ClojureCLR installed, you can run it without involving Docker. E.g. on a Windows box:

```ps
$Env:CLOJURE_LOAD_PATH='src'; Clojure.Main -m starter.hello
```

## About the `deps.edn` file

It might look like this is a tools.deps project, but we only use it to download dependencies and build a CLOJURE_LOAD_PATH (ClojureCLR's version of the classpath).

The `docker compose up` command will result in the creation of a directory `dependencies` in the root of the repository with:
1. The unpacked jar files for the dependencies identified and downloaded by `tools.deps`
1. A `loadpath.sh` file, that will be sourced by [the script](docker/start-repl.sh) starting the REPL

Please see [How to create a really simple ClojureCLR dependency tool](https://blog.agical.se/en/posts/how-to-create-a-really-simple-clojureclr-dependency-tool/) for details and a description of how the ”tooling” of this project is set up.

## WIP

I know almost nothing about .Net and actually have not much clue what I am doing. Expect this project to change as I figure things out a bit. Please don't hesitate to file issues and PRs! 🙏

ClojureCLR is also work in progress as is the nrepl server we are using here.

## Quirks

When using Calva Jack-in (letting Calva start the project and connect), the REPL process keeps running in the container even when the Jack-in is killed from Calva. Jacking in again from this state will fail. You can reconnect to the REPL with the Calva Connect command instead. To kill the REPL, do someting like: `docker compose down && docker compose up`.

## License

See [LICENSE.md](LICENSE.md) (TL;DR: 🗽)

## Happy Coding! ♥️

Please don't hesitate to file issues and PRs to improve this example project.

You find me in the `#clr` and `#calva` (and many other) channels on the [Clojurians Slack](http://clojurians.net/).

