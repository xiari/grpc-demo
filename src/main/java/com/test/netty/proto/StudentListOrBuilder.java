// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc_demo.proto

package com.test.netty.proto;

public interface StudentListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.test.netty.proto.StudentList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.test.netty.proto.Student students = 1;</code>
   */
  java.util.List<com.test.netty.proto.Student> 
      getStudentsList();
  /**
   * <code>repeated .com.test.netty.proto.Student students = 1;</code>
   */
  com.test.netty.proto.Student getStudents(int index);
  /**
   * <code>repeated .com.test.netty.proto.Student students = 1;</code>
   */
  int getStudentsCount();
  /**
   * <code>repeated .com.test.netty.proto.Student students = 1;</code>
   */
  java.util.List<? extends com.test.netty.proto.StudentOrBuilder> 
      getStudentsOrBuilderList();
  /**
   * <code>repeated .com.test.netty.proto.Student students = 1;</code>
   */
  com.test.netty.proto.StudentOrBuilder getStudentsOrBuilder(
      int index);
}
