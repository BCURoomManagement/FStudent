package com.overseas.dao;

import com.overseas.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class getAllDao {
        String username;
        /**
         * freemark模板配置
         */
        private Configuration configuration;
        /**
         * freemark模板的名字
         */
        private String templateName;
        /**
         * 生成文件名
         */
        private String fileName;
        /**
         * 生成文件路径
         */
        private String filePath;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getTemplateName() {
            return templateName;
        }

        public void setTemplateName(String templateName) {
            this.templateName = templateName;
        }

        public void createWord(){

            Template t = null;
            try {

                t = configuration.getTemplate(templateName);


            } catch (IOException e) {
                e.printStackTrace();
            }

            File outFile = new File(filePath+fileName);
            Writer out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Map map = new HashMap<String, Object>();


            /**
             *  Contact
             */


            Contact c=new ContactDao().getContactByName(username);

            map.put("ecname",c.getUsername());
            map.put("ectel",c.getTel());
            map.put("ecemail",c.getFax());
            map.put("ecaddress",c.getAddress());
            map.put("img",getImageStr());
            map.put("tpp","√");
            map.put("tap","√");
            map.put("tid","√");
            map.put("tmd","√");
            map.put("cma","√");
            map.put("tlr"," ");
            map.put("tio"," ");
            map.put("thc"," ");
            map.put("spb"," ");
            map.put("para","√");
            map.put("nbc","√");
            map.put("pew","√");
            map.put("tpa"," ");
            map.put("sota"," ");
            map.put("sotd"," ");



            /**
             *  Family
             *  family type 规定 1：配偶 2：父亲 3：母亲4：子女
             */

            ArrayList<Family> list =new FamilyDao().getFamilyByName(username);

            for(int i=0;i<4;i++)
            {
                Family f=list.get(i);
                switch (f.getType())         //family规定 1：配偶 2：父亲 3：母亲4：子女
                {
                    case "1":
                        map.put("sn",f.getName());
                        map.put("se",f.getEmployment());
                        map.put("st",f.getAge());
                        map.put("see",f.getTel());
                        break;


                    case "2":
                        map.put("fn",f.getName());
                        map.put("fe",f.getEmployment());
                        map.put("ft",f.getAge());
                        map.put("fee",f.getTel());
                        break;

                    case "3":
                        map.put("mn",f.getName());
                        map.put("me",f.getEmployment());
                        map.put("mt",f.getAge());
                        map.put("mee",f.getTel());
                        break;

                    case "4":
                        map.put("dn",f.getName());
                        map.put("de",f.getEmployment());
                        map.put("dt",f.getAge());
                        map.put("dee",f.getTel());
                        break;

                }
            }


            /**
             * Pinf
             * sex 1.男 2.女
             * marri 1.已婚 2.未婚 3.其他
             */
            Pinf p=new PinfDao().getPinfByName(username);
            map.put("fname",p.getFamilyName());
            map.put("gname",p.getGivenName());
            map.put("nation",p.getNationality());
            map.put("ppno",p.getPassportNo());
            String date=p.getDateBirth();
            map.put("dby",date.substring(0,4));
            map.put("dbm",date.substring(4,6));
            map.put("dbd",date.substring(6,8));
            String place=p.getPlaceBirth();
            String data[]=place.split("/");
            map.put("pbco",data[0]);//国家
            map.put("pbci",data[1]);//城市

            String sex=p.getSex();
            switch (sex)
            {
                case "0":
                    map.put("male","√");//男
                    map.put("female"," ");//女
                    break;

                case "1":
                    map.put("male"," ");//
                    map.put("female","√");//
                    break;
            }


            String marri=p.getMarri();
            switch (marri)
            {
                //已婚
                case "1":
                    map.put("marr","√");//
                    map.put("sing"," ");//
                    map.put("oth"," ");//
                    break;

                //未婚
                case "2":
                    map.put("marr"," ");//
                    map.put("sing","√");//
                    map.put("oth"," ");//
                    break;

                //其他
                case "3":
                    map.put("marr"," ");//
                    map.put("sing"," ");//
                    map.put("oth","√");//
                    break;
            }

            map.put("religion",p.getReligion());
            map.put("address",p.getAddressC());
            map.put("tel",p.getCtel());
            map.put("fax",p.getCfax());
            map.put("email",p.getCmail());
            map.put("homeaddress",p.getAddressH());
            map.put("htel",p.getHtel());
            map.put("hfax",p.getHfax());
            map.put("hemail",p.getHmail());


            /**
             * Proficiency
             * 1.很好
             * 2.好
             * 3.较好
             * 4.差
             * 5.不会
             */
            Proficiency pro=new ProficiencyDao().getProficiencyByName(username);
            String proficiency_c=pro.getProficiency_c();
            System.out.println(proficiency_c);
            switch (proficiency_c)
            {
                //很好
                case "1":
                    map.put("cexcell","√");
                    map.put("cgood"," ");
                    map.put("cfair"," ");
                    map.put("cpoor"," ");
                    map.put("cnone"," ");
                    break;

                //好
                case "2":
                    map.put("cexcell"," ");
                    map.put("cgood","√");
                    map.put("cfair"," ");
                    map.put("cpoor"," ");
                    map.put("cnone"," ");
                    break;

                //较好
                case "3":
                    map.put("cexcell"," ");
                    map.put("cgood"," ");
                    map.put("cfair","√");
                    map.put("cpoor"," ");
                    map.put("cnone"," ");
                    break;

                //差
                case "4":
                    map.put("cexcell"," ");
                    map.put("cgood"," ");
                    map.put("cfair"," ");
                    map.put("cpoor","√");
                    map.put("cnone"," ");
                    break;


                //不会
                case "5":
                    map.put("cexcell"," ");
                    map.put("cgood"," ");
                    map.put("cfair"," ");
                    map.put("cpoor","");
                    map.put("cnone","√");
                    break;

            }

            map.put("lohcp",pro.getLevel_c());


            String proficiency_e=pro.getProficiency_e();
            switch (proficiency_e)
            {
                //很好
                case "1":
                    map.put("eexcell","√");
                    map.put("egood"," ");
                    map.put("efair"," ");
                    map.put("epoor"," ");
                    map.put("enone"," ");
                    break;

                //好
                case "2":
                    map.put("eexcell"," ");
                    map.put("egood","√");
                    map.put("efair"," ");
                    map.put("epoor"," ");
                    map.put("enone"," ");
                    break;

                //较好
                case "3":
                    map.put("eexcell"," ");
                    map.put("egood"," ");
                    map.put("efair","√");
                    map.put("epoor"," ");
                    map.put("enone"," ");
                    break;

                //差
                case "4":
                    map.put("eexcell"," ");
                    map.put("egood"," ");
                    map.put("efair"," ");
                    map.put("epoor","√");
                    map.put("enone"," ");
                    break;


                //不会
                case "5":
                    map.put("eexcell"," ");
                    map.put("egood"," ");
                    map.put("efair"," ");
                    map.put("epoor"," ");
                    map.put("enone","√");
                    break;

            }

            map.put("toi",pro.getLevel_e());

            /**
             * Proposed
             *
             * 规定：degree
             * 1、本科生
             * 2、硕士研究生
             * 3、博士研究生
             * 4、研究学者
             * 5、高级进修生
             */
            Proposed proposed=new ProposedDao().getProposedByName(username);
            String degree=proposed.getDegree();
            switch (degree)
            {
                case "1":
                    map.put("bdc","√");
                    map.put("mdc"," ");
                    map.put("ddc"," ");
                    map.put("rs"," ");
                    map.put("ss"," ");
                    break;

                case "2":
                    map.put("bdc"," ");
                    map.put("mdc","√");
                    map.put("ddc"," ");
                    map.put("rs"," ");
                    map.put("ss"," ");
                    break;

                case "3":
                    map.put("bdc"," ");
                    map.put("mdc"," ");
                    map.put("ddc","√");
                    map.put("rs"," ");
                    map.put("ss"," ");
                    break;

                case "4":
                    map.put("bdc"," ");
                    map.put("mdc"," ");
                    map.put("ddc"," ");
                    map.put("rs","√");
                    map.put("ss"," ");
                    break;

                case "5":
                    map.put("bdc"," ");
                    map.put("mdc"," ");
                    map.put("ddc"," ");
                    map.put("rs"," ");
                    map.put("ss","√");
                    break;

            }

            map.put("isfsc",proposed.getSubject());
            String start_time=proposed.getYm_f();
            String fyear=start_time.substring(0,4);
            System.out.println(start_time);
            String fmonth=start_time.substring(4,6);
            map.put("fyear",fyear);
            map.put("fmonth",fmonth);

            String end_time=proposed.getYm_l();
            String yeart=start_time.substring(0,4);

            String tmonth=start_time.substring(4,6);
            map.put("yeart",yeart);
            map.put("tmonth",tmonth);

            map.put("pdd",proposed.getDetails());


            /**
             * Study
             */

            ArrayList<Study> list1=new StudyDao().getStudyByName(username);
            for(int i=0;i<5;i++)
            {

                if(i<list1.size()) {
                    Study st=list1.get(i);
                    map.put("pac_" + (i+1), st.getUnit());
                    map.put("ys_" + (i+1), st.getBtime()+"-"+st.getLtime());
                    map.put("fos_" + (i+1), st.getObj());
                }
                else
                {
                    map.put("pac_" + (i+1), " ");
                    map.put("ys_" + (i+1), " ");
                    map.put("fos_" + (i+1), " ");
                }
            }


            ArrayList<Work> work=new WorkDao().getWorkByName(username);
            for(int i=0;i<5;i++)
            {

                if(i<work.size()) {
                    Work w=work.get(i);
                    map.put("pace_" + (i+1), w.getUnit());
                    map.put("ya_" + (i+1), w.getBtime()+"-"+w.getLtime());
                    map.put("pd_" + (i+1), w.getObj());
                }
                else
                {
                    map.put("pace_" + (i+1), " ");
                    map.put("ya_" + (i+1), " ");
                    map.put("pd_" + (i+1), " ");

                }
            }

            /**
             * Xs
             */

            ArrayList xsList=new XsDao().getXsByName(username);
            for(int i=0;i<5;i++)
            {
                if (i<xsList.size()){
                    Xs xs=(Xs)xsList.get(i);
                    map.put("apw_"+(i+1),xs.getPapers());
                }
                else
                {
                    map.put("apw"," ");
                }
            }

            try {
                t.process(map, out);
                out.close();
            } catch (TemplateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        /**
         * freemark初始化
         * @param templatePath 模板文件位置
         */
        public getAllDao(String templatePath,String user) {
            configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            configuration.setClassForTemplateLoading(this.getClass(),templatePath);
            username = user;
        }
        /**
         * 得到图片
         * @return
         */
        private String getImageStr() {
            String imgFile = "/Users/ezjjjj/Desktop/bk3.jpg";//需要在D盘下指定的目录下放一张图片
            InputStream in = null;
            byte[] data = null;
            try {
                in = new FileInputStream(imgFile);
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BASE64Encoder encoder = new BASE64Encoder();//这里会报错
            return encoder.encode(data);
        }
}
