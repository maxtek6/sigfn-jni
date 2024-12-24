#include <jni.h>

#include <csignal>

#include <string>
#include <unordered_map>

JNIEXPORT int JNICALL Java_jni_SigFn_getSignum(JNIEnv *env, jclass cls, jstring name) {
    const std::unordered_map<std::string, int> signums = {
        {"SIGABRT", SIGABRT},
        {"SIGFPE", SIGFPE},
        {"SIGILL", SIGILL},
        {"SIGINT", SIGINT},
        {"SIGSEGV", SIGSEGV},
        {"SIGTERM", SIGTERM},
    };
    const char *str = env->GetStringUTFChars(name, nullptr);
    int result(-1);
    result = signums.at(str);
    env->ReleaseStringUTFChars(name, str);
    return result;
}