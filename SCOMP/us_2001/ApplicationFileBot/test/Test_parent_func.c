#include "../unity/unity.h"
#include "../src/header.h"

#define INPUT_DIR "test"
circular_buffer *cb;
void setUp(void){
    cb = init_buffer();
}
void tearDown(void){
    free_buffer(cb);
}
//const char *input_dir, circular_buffer *cb
void test_function_should_get_file_prefixes(void) {
    int expected = 30;
    get_file_prefixes(INPUT_DIR, cb);
    int result = dequeue(cb);
    TEST_ASSERT_EQUAL_INT(expected,result);
}


int main(void) {
    UNITY_BEGIN();
    RUN_TEST(test_function_should_beEmpty);
    RUN_TEST(test_function_should_enqueue);
    return UNITY_END();
}