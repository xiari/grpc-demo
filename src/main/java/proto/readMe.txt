protoc --plugin=protoc-gen-grpc-java=/Users/xiayuanyuan/opensource/grpc-java/compiler/build/exe/java_plugin/protoc-gen-grpc-java \
  --grpc-java_out=/Users/xiayuanyuan/devpath/demo/src/main/java --proto_path=/Users/xiayuanyuan/devpath/demo/src/main/java/proto/ rpc_demo.proto

protoc -I=/Users/xiayuanyuan/devpath/demo/src/main/java/proto \
--java_out=/Users/xiayuanyuan/devpath/demo/src/main/java /Users/xiayuanyuan/devpath/demo/src/main/java/proto/rpc_demo.proto

  // protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto


  // /Users/xiayuanyuan/opensource/grpc-java/compiler/build/exe/java_plugin
  //  protoc --plugin=protoc-gen-grpc-java=build/exe/java_plugin/protoc-gen-grpc-java \
  //  --grpc-java_out="$OUTPUT_FILE" --proto_path="$DIR_OF_PROTO_FILE" "$PROTO_FILE"
