# {{ns-name}}


## Building
To build and package the application as a tar.gz file do:

  cd {{ns-name}} # go to project root
  ./scripts/build.sh # to run the full build.
  
This will generate a file called {{ns-name}}.tar.gz


## Deploying to production

To deploy this to a server

  scp {{ns-name}}.tar.gz user@server_ip:~/  # to copy the app to a server

  ssh user@server_ip # to connect that machine
  
  tar -xvf {{ns-name}}.tar.gz # to extract the app

  cd {{ns-name}} 

  ./start.sh


To the currently running instance on the server

  ./stop.sh # will stop the daemon
  



Servers need to have java and jsvc installed.


## Development

lein repl # starts a repl... 

in repl do (user/go) # to start a dev server on port 3000 (by default)

any change to the code needs the code to be revaluated an (user/go) to be called again in order to propagate any changes in all components


## Usage

FIXME
