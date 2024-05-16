#include "../unity/unity.h"
#include "../src/header.h"

void setUp(void)
{
}
void tearDown(void)
{
}

void test_function_should_create_noChildren(void)
{
    pid_t child_pids[2][2];
    int result = create_child_process(0, child_pids);
    TEST_ASSERT_EQUAL_INT(0, result);
}
void test_function_should_create_Children(void)
{
    pid_t child_pids[2][2];
    int result = create_child_process(2, child_pids);
    TEST_ASSERT_NOT_EQUAL_INT(-1, result);
    for (int i = 0; i < 2; i++)
    {
        kill(child_pids[i][0], SIGKILL);
    }
}
void test_function_should_create_pipes(void)
{
    int pipes[2][2];
    int result = create_pipes(pipes, 2);
    TEST_ASSERT_NOT_EQUAL_INT(1, result);
}
void test_function_should_create_zero_pipes(void)
{
    int pipes[2][2];
    int result = create_pipes(pipes, 0);
    TEST_ASSERT_EQUAL_INT(0, result);
}
int main(void)
{
    UNITY_BEGIN();
    RUN_TEST(test_function_should_beEmpty);
    RUN_TEST(test_function_should_enqueue);
    return UNITY_END();
}