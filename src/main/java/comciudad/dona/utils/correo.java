package comciudad.dona.utils;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
@Component
public class correo {
	public String getHtmlContent(String otp) {
	      String htmlContent = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
	      		+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n"
	      		+ "\r\n"
	      		+ "<head>\r\n"
	      		+ "  <!--[if gte mso 9]>\r\n"
	      		+ "<xml>\r\n"
	      		+ "  <o:OfficeDocumentSettings>\r\n"
	      		+ "    <o:AllowPNG/>\r\n"
	      		+ "    <o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
	      		+ "  </o:OfficeDocumentSettings>\r\n"
	      		+ "</xml>\r\n"
	      		+ "<![endif]-->\r\n"
	      		+ "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n"
	      		+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	      		+ "  <meta name=\"x-apple-disable-message-reformatting\">\r\n"
	      		+ "  <!--[if !mso]><!-->\r\n"
	      		+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\r\n"
	      		+ "  <title></title>\r\n"
	      		+ "\r\n"
	      		+ "  <style type=\"text/css\">\r\n"
	      		+ "    @media only screen and (min-width: 620px) {\r\n"
	      		+ "      .u-row {\r\n"
	      		+ "        width: 600px !important;\r\n"
	      		+ "      }\r\n"
	      		+ "\r\n"
	      		+ "      .u-row .u-col {\r\n"
	      		+ "        vertical-align: top;\r\n"
	      		+ "      }\r\n"
	      		+ "\r\n"
	      		+ "      .u-row .u-col-100 {\r\n"
	      		+ "        width: 600px !important;\r\n"
	      		+ "      }\r\n"
	      		+ "\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    @media (max-width: 620px) {\r\n"
	      		+ "      .u-row-container {\r\n"
	      		+ "        max-width: 100% !important;\r\n"
	      		+ "        padding-left: 0px !important;\r\n"
	      		+ "        padding-right: 0px !important;\r\n"
	      		+ "      }\r\n"
	      		+ "\r\n"
	      		+ "      .u-row .u-col {\r\n"
	      		+ "        min-width: 320px !important;\r\n"
	      		+ "        max-width: 100% !important;\r\n"
	      		+ "        display: block !important;\r\n"
	      		+ "      }\r\n"
	      		+ "\r\n"
	      		+ "      .u-row {\r\n"
	      		+ "        width: 100% !important;\r\n"
	      		+ "      }\r\n"
	      		+ "\r\n"
	      		+ "      .u-col {\r\n"
	      		+ "        width: 100% !important;\r\n"
	      		+ "      }\r\n"
	      		+ "\r\n"
	      		+ "      .u-col>div {\r\n"
	      		+ "        margin: 0 auto;\r\n"
	      		+ "      }\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    body {\r\n"
	      		+ "      margin: 0;\r\n"
	      		+ "      padding: 0;\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    table,\r\n"
	      		+ "    tr,\r\n"
	      		+ "    td {\r\n"
	      		+ "      vertical-align: top;\r\n"
	      		+ "      border-collapse: collapse;\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    p {\r\n"
	      		+ "      margin: 0;\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    .ie-container table,\r\n"
	      		+ "    .mso-container table {\r\n"
	      		+ "      table-layout: fixed;\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    * {\r\n"
	      		+ "      line-height: inherit;\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    a[x-apple-data-detectors='true'] {\r\n"
	      		+ "      color: inherit !important;\r\n"
	      		+ "      text-decoration: none !important;\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    table,\r\n"
	      		+ "    td {\r\n"
	      		+ "      color: #000000;\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    #u_body a {\r\n"
	      		+ "      color: #0000ee;\r\n"
	      		+ "      text-decoration: underline;\r\n"
	      		+ "    }\r\n"
	      		+ "\r\n"
	      		+ "    @media (max-width: 480px) {\r\n"
	      		+ "      #u_content_text_6 .v-text-align {\r\n"
	      		+ "        text-align: center !important;\r\n"
	      		+ "      }\r\n"
	      		+ "    }\r\n"
	      		+ "  </style>\r\n"
	      		+ "\r\n"
	      		+ "\r\n"
	      		+ "\r\n"
	      		+ "  <!--[if !mso]><!-->\r\n"
	      		+ "  <link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\r\n"
	      		+ "\r\n"
	      		+ "</head>\r\n"
	      		+ "\r\n"
	      		+ "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9f9;color: #000000\">\r\n"
	      		+ "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\r\n"
	      		+ "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\r\n"
	      		+ "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
	      		+ "    <tbody>\r\n"
	      		+ "      <tr style=\"vertical-align: top\">\r\n"
	      		+ "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
	      		+ "          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #f9f9f9;\"><![endif]-->\r\n"
	      		+ "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
	      		+ "            <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #fe0002;\">\r\n"
	      		+ "              <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
	      		+ "                <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #fe0002;\"><![endif]-->\r\n"
	      		+ "\r\n"
	      		+ "                <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
	      		+ "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
	      		+ "                  <div style=\"height: 100%;width: 100% !important;\">\r\n"
	      		+ "                    <!--[if (!mso)&(!IE)]><!-->\r\n"
	      		+ "                    <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
	      		+ "\r\n"
	      		+ "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
	      		+ "                        <tbody>\r\n"
	      		+ "                          <tr>\r\n"
	      		+ "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
	      		+ "\r\n"
	      		+ "                              <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
	      		+ "                                <tr>\r\n"
	      		+ "                                  <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\r\n"
	      		+ "\r\n"
	      		+ "                                    <img align=\"center\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1597218650916-xxxxc.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 26%;max-width: 150.8px;\" width=\"150.8\" />\r\n"
	      		+ "\r\n"
	      		+ "                                  </td>\r\n"
	      		+ "                                </tr>\r\n"
	      		+ "                              </table>\r\n"
	      		+ "\r\n"
	      		+ "                            </td>\r\n"
	      		+ "                          </tr>\r\n"
	      		+ "                        </tbody>\r\n"
	      		+ "                      </table>\r\n"
	      		+ "\r\n"
	      		+ "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
	      		+ "                        <tbody>\r\n"
	      		+ "                          <tr>\r\n"
	      		+ "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 31px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
	      		+ "\r\n"
	      		+ "                              <div class=\"v-text-align\" style=\"font-size: 14px; color: #e5eaf5; line-height: 140%; text-align: center; word-wrap: break-word;\">\r\n"
	      		+ "                                <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 28px; line-height: 39.2px; font-family: 'arial black', AvenirNext-Heavy, 'avant garde', arial;\"><strong><span style=\"line-height: 39.2px; font-size: 28px;\">Ciudadona</span></strong></span></p>\r\n"
	      		+ "                              </div>\r\n"
	      		+ "\r\n"
	      		+ "                            </td>\r\n"
	      		+ "                          </tr>\r\n"
	      		+ "                        </tbody>\r\n"
	      		+ "                      </table>\r\n"
	      		+ "\r\n"
	      		+ "                      <!--[if (!mso)&(!IE)]><!-->\r\n"
	      		+ "                    </div><!--<![endif]-->\r\n"
	      		+ "                  </div>\r\n"
	      		+ "                </div>\r\n"
	      		+ "                <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
	      		+ "                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
	      		+ "              </div>\r\n"
	      		+ "            </div>\r\n"
	      		+ "          </div>\r\n"
	      		+ "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
	      		+ "            <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\r\n"
	      		+ "              <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
	      		+ "                <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\r\n"
	      		+ "\r\n"
	      		+ "                <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
	      		+ "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
	      		+ "                  <div style=\"height: 100%;width: 100% !important;\">\r\n"
	      		+ "                    <!--[if (!mso)&(!IE)]><!-->\r\n"
	      		+ "                    <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
	      		+ "\r\n"
	      		+ "                      <table id=\"u_content_text_6\" style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
	      		+ "                        <tbody>\r\n"
	      		+ "                          <tr>\r\n"
	      		+ "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:33px 55px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
	      		+ "\r\n"
	      		+ "                              <div class=\"v-text-align\" style=\"font-size: 14px; line-height: 160%; text-align: center; word-wrap: break-word;\">\r\n"
	      		+ "                                <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 22px; line-height: 35.2px;\">Hola</span></p>\r\n"
	      		+ "                                <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 18px; line-height: 28.8px;\">Hemos recibido una solicitud para restablecer tu contraseña. Si no has hecho esta solicitud, puedes ignorar este correo electrónico &nbsp;</span></p>\r\n"
	      		+ "                                <p style=\"font-size: 14px; line-height: 160%;\"><strong><span style=\"font-size: 18px; line-height: 28.8px;\">código de verificación </span></strong></p>\r\n"
	      		+ "                                <p style=\"line-height: 160%;\"><span style=\"font-family: arial black, AvenirNext-Heavy, avant garde, arial;\"><span style=\"font-size: 28px; line-height: 44.8px;\"><strong> " + otp +
	              "</strong></span></span></p>\r\n"
	              + "                                <p style=\"font-size: 14px; line-height: 160%;\">&nbsp;</p>\r\n"
	              + "                              </div>\r\n"
	              + "\r\n"
	              + "                            </td>\r\n"
	              + "                          </tr>\r\n"
	              + "                        </tbody>\r\n"
	              + "                      </table>\r\n"
	              + "                      <!--[if (!mso)&(!IE)]><!-->\r\n"
	              + "                    </div><!--<![endif]-->\r\n"
	              + "                  </div>\r\n"
	              + "                </div>\r\n"
	              + "                <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
	              + "                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
	              + "              </div>\r\n"
	              + "            </div>\r\n"
	              + "          </div>\r\n"  + " <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
	              + "            <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #e5eaf5;\">\r\n"
	              + "              <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
	              + "                <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #e5eaf5;\"><![endif]-->\r\n"
	              + "                <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #c2e0f4;width: 600px;padding: 0px;border-top: 0px dotted transparent;border-left: 0px dotted transparent;border-right: 0px dotted transparent;border-bottom: 0px dotted transparent;\" valign=\"top\"><![endif]-->\r\n"
	              + "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
	              + "                  <div style=\"background-color: #c2e0f4;height: 100%;width: 100% !important;\">\r\n"
	              + "                    <!--[if (!mso)&(!IE)]><!-->\r\n"
	              + "                    <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px dotted transparent;border-left: 0px dotted transparent;border-right: 0px dotted transparent;border-bottom: 0px dotted transparent;\"><!--<![endif]-->\r\n"
	              + "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
	              + "                        <tbody>\r\n"
	              + "                          <tr>\r\n"
	              + "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:41px 55px 18px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
	              + "                              <div class=\"v-text-align\" style=\"font-size: 14px; color: #000000; line-height: 160%; text-align: center; word-wrap: break-word;\">\r\n"
	              + "                                <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 20px; line-height: 32px;\"><strong>Ciudadona</strong></span></p>\r\n"
	              + "                                <p style=\"font-size: 14px; line-height: 160%;\">+51 969 738 698</p>\r\n"
	              + "                                <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 18px; line-height: 28.8px;\">ciudadona@gmail.</span><span style=\"font-size: 16px; line-height: 25.6px;\"><span style=\"font-size: 18px; line-height: 28.8px;\">com</span> </span></p>\r\n"
	              + "                              </div>\r\n"
	              + "\r\n"
	              + "                            </td>\r\n"
	              + "                          </tr>\r\n"
	              + "                        </tbody>\r\n"
	              + "                      </table>\r\n"
	              + "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
	              + "                        <tbody>\r\n"
	              + "                          <tr>\r\n"
	              + "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 33px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
	              + "                              <div align=\"center\">\r\n"
	              + "                                <div style=\"display: table; max-width:195px;\">\r\n"
	              + "                                  <!--[if (mso)|(IE)]><table width=\"195\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:195px;\"><tr><![endif]-->\r\n"
	              + "\r\n"
	              + "\r\n"
	              + "                                  <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 17px;\" valign=\"top\"><![endif]-->\r\n"
	              + "                                  <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 17px\">\r\n"
	              + "                                    <tbody>\r\n"
	              + "                                      <tr style=\"vertical-align: top\">\r\n"
	              + "                                        <td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
	              + "                                          <a href=\"https://www.facebook.com/ciudadona/\" title=\"Facebook\" target=\"_blank\">\r\n"
	              + "                                            <img src=\"https://cdn.tools.unlayer.com/social/icons/circle-black/facebook.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
	              + "                                          </a>\r\n"
	              + "                                        </td>\r\n"
	              + "                                      </tr>\r\n"
	              + "                                    </tbody>\r\n"
	              + "                                  </table>\r\n"
	              + "                                  <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
	              + "\r\n"
	              + "                                  <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 17px;\" valign=\"top\"><![endif]-->\r\n"
	              + "                                  <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 17px\">\r\n"
	              + "                                    <tbody>\r\n"
	              + "                                      <tr style=\"vertical-align: top\">\r\n"
	              + "                                        <td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
	              + "                                          <a href=\"https://www.instagram.com/ciudadona/\" title=\"Instagram\" target=\"_blank\">\r\n"
	              + "                                            <img src=\"https://cdn.tools.unlayer.com/social/icons/circle-black/instagram.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
	              + "                                          </a>\r\n"
	              + "                                        </td>\r\n"
	              + "                                      </tr>\r\n"
	              + "                                    </tbody>\r\n"
	              + "                                  </table>\r\n"
	              + "                                  <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
	              + "\r\n"
	              + "                                  <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 17px;\" valign=\"top\"><![endif]-->\r\n"
	              + "                                  <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 17px\">\r\n"
	              + "                                    <tbody>\r\n"
	              + "                                      <tr style=\"vertical-align: top\">\r\n"
	              + "                                        <td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
	              + "                                          <a href=\"https://www.youtube.com/@Ciudadona\" title=\"YouTube\" target=\"_blank\">\r\n"
	              + "                                            <img src=\"https://cdn.tools.unlayer.com/social/icons/circle-black/youtube.png\" alt=\"YouTube\" title=\"YouTube\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
	              + "                                          </a>\r\n"
	              + "                                        </td>\r\n"
	              + "                                      </tr>\r\n"
	              + "                                    </tbody>\r\n"
	              + "                                  </table>\r\n"
	              + "                                  <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
	              + "\r\n"
	              + "                                  <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\r\n"
	              + "                                  <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\r\n"
	              + "                                    <tbody>\r\n"
	              + "                                      <tr style=\"vertical-align: top\">\r\n"
	              + "                                        <td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
	              + "                                          <a href=\"https://www.tiktok.com/@ciudadona.com\" title=\"TikTok\" target=\"_blank\">\r\n"
	              + "                                            <img src=\"https://cdn.tools.unlayer.com/social/icons/circle-black/tiktok.png\" alt=\"TikTok\" title=\"TikTok\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
	              + "                                          </a>\r\n"
	              + "                                        </td>\r\n"
	              + "                                      </tr>\r\n"
	              + "                                    </tbody>\r\n"
	              + "                                  </table>\r\n"
	              + "                                  <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
	              + "\r\n"
	              + "\r\n"
	              + "                                  <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
	              + "                                </div>\r\n"
	              + "                              </div>\r\n"
	              + "\r\n"
	              + "                            </td>\r\n"
	              + "                          </tr>\r\n"
	              + "                        </tbody>\r\n"
	              + "                      </table>\r\n"
	              + "\r\n"
	              + "                      <!--[if (!mso)&(!IE)]><!-->\r\n"
	              + "                    </div><!--<![endif]-->\r\n"
	              + "                  </div>\r\n"
	              + "                </div>\r\n"
	              + "                <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
	              + "                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
	              + "              </div>\r\n"
	              + "            </div>\r\n"
	              + "          </div>\r\n"
	              + "\r\n"
	              + "\r\n"
	              + "\r\n"
	              + "\r\n"
	              + "\r\n"
	              + "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
	              + "            <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #003399;\">\r\n"
	              + "              <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
	              + "                <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #003399;\"><![endif]-->\r\n"
	              + "\r\n"
	              + "                <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #fe0002;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
	              + "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
	              + "                  <div style=\"background-color: #fe0002;height: 100%;width: 100% !important;\">\r\n"
	              + "                    <!--[if (!mso)&(!IE)]><!-->\r\n"
	              + "                    <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
	              + "\r\n"
	              + "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
	              + "                        <tbody>\r\n"
	              + "                          <tr>\r\n"
	              + "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
	              + "\r\n"
	              + "                              <div class=\"v-text-align\" style=\"font-size: 14px; color: #fafafa; line-height: 180%; text-align: center; word-wrap: break-word;\">\r\n"
	              + "                                <p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-size: 16px; line-height: 28.8px;\">Copyrights © ciudadona</span></p>\r\n"
	              + "                              </div>\r\n"
	              + "\r\n"
	              + "                            </td>\r\n"
	              + "                          </tr>\r\n"
	              + "                        </tbody>\r\n"
	              + "                      </table>\r\n"
	              + "\r\n"
	              + "                      <!--[if (!mso)&(!IE)]><!-->\r\n"
	              + "                    </div><!--<![endif]-->\r\n"
	              + "                  </div>\r\n"
	              + "                </div>\r\n"
	              + "                <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
	              + "                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
	              + "              </div>\r\n"
	              + "            </div>\r\n"
	              + "          </div>\r\n"
	              + "\r\n"
	              + "\r\n"
	              + "\r\n"
	              + "          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n"
	              + "        </td>\r\n"
	              + "      </tr>\r\n"
	              + "    </tbody>\r\n"
	              + "  </table>\r\n"
	              + "  <!--[if mso]></div><![endif]-->\r\n"
	              + "  <!--[if IE]></div><![endif]-->\r\n"
	              + "</body>\r\n"
	              + "\r\n"
	              + "</html>";

	      return htmlContent;
	  }
}
