#include "../unity/unity.h"
#include "../src/header.h"

circular_buffer *cb;
void setUp(void){
    cb = init_buffer();
}
void tearDown(void){
    free_buffer(cb);
}
void test_function_should_beEmpty(void) {
    int expected = 1;
    int result = is_empty(cb);
    TEST_ASSERT_EQUAL_INT(expected, result);
}
void test_function_should_enqueue(void) {
    int expected = 1;//count, if enqueue good, should be 1

    int number = 30;
    enqueue(cb, number);
    int result = cb->count;
    
    TEST_ASSERT_EQUAL_INT(1, result);
}

void test_function_should_beFull(void) {
    int i, expected = 1;
    for (i = 0; i < BUFFER_SIZE; i++)
    {
        enqueue(cb, i);
    }
    int result = is_full(cb);

    TEST_ASSERT_EQUAL_INT(expected, result);
}


void test_function_should_dequeue(void) {
    int expected = 9;
    dequeue(cb);
    int result = cb->count;

    TEST_ASSERT_EQUAL_INT(expected, result);
}


int main(void) {
    UNITY_BEGIN();
    RUN_TEST(test_function_should_beEmpty);
    RUN_TEST(test_function_should_enqueue);
    RUN_TEST(test_function_should_beFull);
    RUN_TEST(test_function_should_dequeue);
    return UNITY_END();
}