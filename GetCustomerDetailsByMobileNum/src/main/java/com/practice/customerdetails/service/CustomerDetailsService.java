package com.practice.customerdetails.service;

import com.practice.customerdetails.model.CustomerDetails;
import com.practice.customerdetails.model.CustomerDetailsProxy;
import com.practice.customerdetails.model.CustomerMobileNum;
import com.practice.customerdetails.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


@Service
public class CustomerDetailsService {
    @Autowired
    private CustomerDetailsProxy customerDetailsProxy;


    public Response getDetails(CustomerMobileNum customerMobileNum) {
        String reqXml = "<input Operation=\"getCustDetailsByMobileNo(SessionContext,String)\">\n" +
                "\t<SessionContext>\n" +
                "\t\t<BranchCode>10032</BranchCode>\n" +
                "\t\t<Channel>IEXCEED</Channel>\n" +
                "\t\t<ExternalReferenceNo>2017122917071234</ExternalReferenceNo>\n" +
                "\t\t<SupervisorContext>\n" +
                "\t\t\t<UserId>IEXCEED</UserId>\n" +
                "\t\t\t<PrimaryPassword>V2VsY29tZUAxMjM=</PrimaryPassword>\n" +
                "\t\t</SupervisorContext>\n" +
                "\t</SessionContext>\n" +
                "\t<MobileNumber>" + customerMobileNum.getMobileNum() + "</MobileNumber>\n" +
                "</input>";


        Response response = new Response();
        ArrayList<CustomerDetails> customerList = new ArrayList<>();

        String resXml = customerDetailsProxy.getDetails(reqXml);


        try {
            System.out.println("try");

            InputStream inputStream = new ByteArrayInputStream(resXml.getBytes(StandardCharsets.UTF_8));
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(inputStream);

            if (document.getElementsByTagName("ErrorCode") != null && document.getElementsByTagName("ErrorCode").item(0).getTextContent().equals("0")) {


                System.out.println("if" + document.getElementsByTagName("Record").getLength());
                int len = document.getElementsByTagName("Record").getLength();
                for (int i = 0; i < len; i++) {
                    CustomerDetails customerDetails = new CustomerDetails();
                    System.out.println("for" + i);

                    //try {
                        if ((document.getElementsByTagName("CustomerName").item(i) != null))
                        {
                            customerDetails.setCustomerName(document.getElementsByTagName("CustomerName").item(i).getTextContent());
                        }
                    //} catch (Exception e)
//                    {
//                        System.out.println("1");
//                    }
                    //try {
                        if ((document.getElementsByTagName("CustomerNumber").item(i) != null))
                        {
                            customerDetails.setCustomerNumber(document.getElementsByTagName("CustomerNumber").item(i).getTextContent());
                        }
//                    } catch (Exception e) {
//                        System.out.println("2");
//                    }

                    //try {
                        if ((document.getElementsByTagName("AadharReferenceNumber").item(i) != null)) {
                            customerDetails.setAadharReferenceNumber(document.getElementsByTagName("AadharReferenceNumber").item(i).getTextContent());
                        }
//                    }
//                    catch (Exception e) {
//                        System.out.println("3");
//                    }
//                    try
//                    {
                        if ((document.getElementsByTagName("AMLRiskRating").item(i) != null)) {
                            customerDetails.setAmlRiskRating(document.getElementsByTagName("AMLRiskRating").item(i).getTextContent());
                        }
//                    }
//                    catch (Exception e)
//                    {
//                        System.out.println("4");
//                    }
                    customerList.add(customerDetails);
                }

                System.out.println(customerList.toString());
                response.setStatus("ok");
                response.setMessage("success");
                response.setCustomerDetails(customerList);
            }
             else {
                System.out.println("else");
                response.setStatus("failed");
                response.setMessage("Pls Give A valid mobile number");
                response.setCustomerDetails(customerList);

            }
        } catch (Exception ex) {
            System.out.println("catch");
            System.out.println(ex.getMessage());
        }
        return response;
    }
}
