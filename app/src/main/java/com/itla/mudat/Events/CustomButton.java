package com.itla.mudat.Events;

import android.view.View;
import android.widget.Button;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by Miguel Peralta on 11/11/2017.
 */
public class CustomButton {

    private Button btn;
    private Class <?> cls;


    /**
     * construct
     * @param btn
     */
    public CustomButton(Button btn, String className) {

        try {

            this.btn = btn;
            this.cls = Class.forName(className);
            Object objectClass = this.cls.newInstance();

        } catch (ClassNotFoundException cnfexc) {
            System.out.println(cnfexc.getMessage());
        } catch (InstantiationException iexc) {
            System.out.println(iexc.getMessage());

        } catch (IllegalAccessException iaexc) {
            System.out.println(iaexc.getMessage());
        }
    }

    private void callMethod( String mn ) {

        Method[] allMethods = this.cls.getDeclaredMethods();
        for (Method method : allMethods) {
            String nameMethod = method.getName();
            if( nameMethod != mn ) {
                continue;
            }
//                if (!mname.startsWith("test")
//                        || (m.getGenericReturnType() != boolean.class)) {
//                    continue;
//                }
//                Type[] pType = m.getGenericParameterTypes();
//                if ((pType.length != 1)
//                        || Locale.class.isAssignableFrom(pType[0].getClass())) {
//                    continue;
//                }
//
//                out.format("invoking %s()%n", mname);
            try {
//                    method.setAccessible(true);
//                    Object o = method.invoke(t, new Locale(args[1], args[2], args[3]));
                Object obj = method.invoke(this.cls);
//                    out.format("%s() returned %b%n", mname, (Boolean) o);
                System.out.println(obj);
                // Handle any exceptions thrown by method to be invoked.
            } catch (InvocationTargetException itexc) {
//                Throwable cause = x.getCause();
                System.out.println(itexc.getMessage());
//                    err.format("invocation of %s failed: %s%n", nameMethod, cause.getMessage());
            } catch (IllegalAccessException iaexc) {
                System.out.println(iaexc.getMessage());
            }
        }

    }

    /**
     * click event
     */
    public void click(final String methodName) {

        this.btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CustomButton.this.callMethod(methodName);
            }
        });

    }

}
