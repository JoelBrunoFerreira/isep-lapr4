# US 1000 - As Administrator, I want to be able to register, disable/enable, and list users of the backoffice


## Test Plan

## Case #1: Register new User
 >1. Login as Admin
 >2. Create a new user
 >3. Select role
 >4. Insert name and e-mail
 >5. Submit
 >6. List users to confirm User creation


## Case #2: Register repeated User
>1. Login as Admin
>2. Run case #1
>3. Run case #1 with the same input
>4. The system shall alert that the User already exists


## Case #3: Register User without e-mail or name
>1. Login as Admin
>2. Create a new user
>3. Select role
>4. Submit
>4. The system shall alert that the User must have e-mail and name

