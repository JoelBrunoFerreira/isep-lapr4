package customer.application;

import java.io.IOException;

public class CustomerLoginController {
    public boolean login(String username, String password) throws IOException {
        return SrvProxy.customerLogin(username, password);
    }
}
