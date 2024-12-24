cmake_minimum_required(VERSION 3.10)

project(sigfn-jni)

find_package(Java REQUIRED)
# https://stackoverflow.com/questions/51047978/cmake-could-not-find-jni
set(JAVA_AWT_LIBRARY NotNeeded)
set(JAVA_JVM_LIBRARY NotNeeded)
find_package(JNI REQUIRED)

include(FetchContent)
FetchContent_Declare(
  sigfn
  GIT_REPOSITORY https://github.com/maxtek6/sigfn.git
  GIT_TAG        master)
FetchContent_MakeAvailable(sigfn)

add_subdirectory(src/main/cpp)