package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object Inspector_username
     
    /**
     * <p></p>
     */
    public static Object Inspector_password
     
    /**
     * <p></p>
     */
    public static Object Case_ID
     
    /**
     * <p></p>
     */
    public static Object base_url
     
    /**
     * <p></p>
     */
    public static Object Email
     
    /**
     * <p></p>
     */
    public static Object password
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            URL = selectedVariables['URL']
            Inspector_username = selectedVariables['Inspector_username']
            Inspector_password = selectedVariables['Inspector_password']
            Case_ID = selectedVariables['Case_ID']
            base_url = selectedVariables['base_url']
            Email = selectedVariables['Email']
            password = selectedVariables['password']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
