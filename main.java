
class Commerce{

    public static void main(String[] args){
    }

    public boolean AddUser(String Login_id){
        // Check if User already exist in the system
        // Prompt user to input password
        // Prompt user to Choose Premium user (y(es)?/n(o)?) (Ignore Case)
        // Decide what to return maybe User Status enum {SuccessToCreated, Exist, FailedToCreate}

        return false;
    }

    public boolean RemoveUser(String Login_id){
        // Check If user exist in the data base
        // Check if current logged user is the deleted user???
        // Remove From the Database
        // Return SuccessToRemove, FailedToRemove
        return false;
    }

    public boolean Login(String Login_id, String password){
        // Check if already anthor user is connected if true Prompt 'A User already logged to the system, Try again later!'
        // Check if login_id exist in the Users Database
        // Verify password
        // Update the Global system logged user
        // Prompt to user 'Welcome Login_id you are logged!'
        return false;
    }

    public boolean Logout(String login_id){
        // check if current user is logged
        // log out from system Prompt - 'Bye {login_id}, You are logged out'
        return false;
    }

    public boolean CreateNewOrder(String address){
        // 
        return false;
    }
    
}