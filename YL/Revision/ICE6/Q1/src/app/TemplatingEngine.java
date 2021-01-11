package app;

import businessobject.*;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by yeowleong on 8/5/14.
 */
public class TemplatingEngine {
    public static void main(String[] args) throws IOException {

        // the POJO(Plain Old Java Objects) objects
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("apple",3, 1.2));
        products.add(new Product("orange",2, 0.50));
        products.add(new Product("pear",10, 0.75));





        VelocityContext context = new VelocityContext();
        context.put("products", products);

         /*
           The Template object is the parsed version of yor template input file
           Note that getTemplate() can throw
           - ResourceNotFoundException : if it doesn't find the template
           - ParseErrorException : if there is something wrong with the syntax
           - Exception : if something else goes wrong (this is generally
                         indicative of as serious problem...)
         */

        Template template = null;

        String templateFile = "template/example.vm";
        try {
            template = Velocity.getTemplate(templateFile);
        } catch (ResourceNotFoundException e) {
            System.out.println("Example : error : cannot find template " + templateFile);
        } catch (ParseErrorException e) {
            System.out.println("Example : Syntax error in template " + templateFile + ":" + e);
        }

        /*
          merging the data with the template
         */
        BufferedWriter writer  = new BufferedWriter(
                new OutputStreamWriter(System.out));

        if (template != null)
            template.merge(context, writer);

        /*
          flush and cleanup
        */

        writer.flush();
        writer.close();
    }



}
