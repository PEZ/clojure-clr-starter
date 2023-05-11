# A Dockerized mini-project for testing ClojureCLR

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

This will create and start the Docker compostion consisting of one service named `dotnet-clojure`. This is where we will start the project and its nREPL server.

## Start the REPL and Connect your editor

If you are using [Calva](https://calva.io) _and are not using Windows_, you can now start the project REPL and connect it with:

1. Run the command **Calva: Start a Project REPL and Connect (a.k.a.Jack-in)**, <kbd>ctrl</kbd>+<kbd>alt</kbd>+<kbd>c</kbd> <kbd>ctrl</kbd>+<kbd>alt</kbd>+<kbd>j</kbd>
2. Select the project root **clojure-clr-mini** (the *Workspace Root*)
3. Select the project type/sequence: **ClojureCLR Starter**

If you are using Calva _and Windows_: Start the REPL as per [below](#start-the-repl) and then do [Connect your editor](#connect-your-editor) using the above steps, replacing the first one with **Calva: Connect to a Running REPL in Your Project**.

If you are using some other editor, please read on.

### Start the REPL

From a terminal:

```sh
docker-compose exec -it dotnet-clojure /app/docker/start-repl.sh
```

### Connect your editor

When the command above prints:

```
Started nREPL server at localhost:6667
```

you can connect your editor to the REPL and hack away.

## About the Leiningen `project.clj` file

It might look like this is a Leiningen project, but Leiningen is only used to download dependencies and build a classpath (CLOJURE_LOAD_PATH in ClojureCLR's case). 

The `docker compose up` command will result in the creation of a directory `dependencies` in the root of the repository with the unpacked jar files for the dependencies identified and downloaded by Leiningen. And the directories there will be added to the load path.

## WIP

I know almost nothing about .Net and actually have no clue what I am doing. Expect this project to change as I figure things out a bit.

ClojureCLR is also work in progress as is the nrepl server we are using here.

## License

See [LICENSE.md](LICENSE.md) (TL;DR: 🗽)

## Happy Coding! ♥️

Please don't hesitate to file issues and PRs to improve this example project.

You find me in the `#clr` and `#calva` (and many other) channels on the [Clojurians Slack](http://clojurians.net/).

