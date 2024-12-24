add_library(sigfn_jni SHARED sigfn_jni.cpp)

target_link_libraries(sigfn_jni PRIVATE sigfn::StaticLibrary)