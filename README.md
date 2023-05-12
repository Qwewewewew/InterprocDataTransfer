# InterprocDataTransfer

## About

Mini dual-thread UDP chat app. Just messing around trying to explore ways to transfer data between two apps
## Usage

You can either launch the `.jar` in the `./out/` folder or build app by yourself:

```sh
mkdir -p bin/
cd src/
javac me/qwew/chat/Main.java -d ../bin/
cd ../bin/
```

Then run

```sh
java me.qwew.chat.Main [destIP] [destPort]
```

where you can optionally pass `destIP` as destination IP, `destPort` as listening port on destination host. If skipped, you will be prompted later. If nothing entered, the defaults are set: `127.0.0.1:8081`

## Restrictions and issues
- This client is bind to `8080` and to `8081` ports as sender and listener respectively by default. Can be changed in the code directly
- Message limit is set to 1 kB for now at least

Have fun!