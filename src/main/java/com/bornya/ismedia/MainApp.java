package com.bornya.ismedia;

import com.bornya.ismedia.exception.IncompleteParamException;
import com.bornya.ismedia.model.Proxy;
import org.apache.commons.cli.*;

public class MainApp {

    public static void main(String[] args) throws ParseException {
        // Create a Parser
        CommandLineParser parser = new BasicParser( );

        Options options = new Options();

        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("a", "auth", false, "Auth to video platform");
        options.addOption("u", "upload", false, "Upload yor video to designated platform");
        options.addOption(null, "platform", true, "The platform name, support 'youtube' and 'bilibili', " +
                "Notice: Specifying as 'all' means operating on all platforms and specifying multiple platforms separated by commas means operating on multiple platforms " +
                "when uploading, modifying or removing");
        options.addOption(null, "user", true, "This parameter will be used to store the token corresponding to your username, " +
                "you can ignore this parameter, and isMedia will set it to a default value.");
        options.addOption(null, "video", true, "the video information, it should be specified as a json format string");
        options.addOption(null, "proxy-host", true, "the proxy host");
        options.addOption(null, "proxy-port", true, "the proxy port");
                
        // Parse the program arguments
        CommandLine commandLine = parser.parse(options, args);

        if(commandLine.hasOption("h")){
            HelpFormatter hf = new HelpFormatter();
            hf.setWidth(110);
            hf.printHelp("isMedia", options, true);
            System.exit(0);
        }

        if(commandLine.hasOption("proxy-host")){
            if(commandLine.hasOption("proxy-port")){
                String host = commandLine.getOptionValue("proxy-host");
                int port = Integer.valueOf(commandLine.getOptionValue("proxy-port"));
                AppTrigger.getInstance().setProxy(new Proxy(host, port));
            }else {
                throw new IncompleteParamException("ERROR: You specified the 'proxy-host' parameter, but it seems that you did not specify the 'proxy-port'");
            }
        }

        if(commandLine.hasOption("a")){
            String platform = null;
            String userName = null;
            //鉴权操作
            if(commandLine.hasOption("platform")){
                platform = commandLine.getOptionValue("platform");
            }else {
                throw new IncompleteParamException("ERROR: Please specify the platform name, or see the detail for -h/--help");
            }
            if(commandLine.hasOption("user")){
                userName = commandLine.getOptionValue("user");
            }
            AppTrigger.getInstance().toAuth(platform, userName);
        }else if(commandLine.hasOption('u')){
            String userName = null;
            String platform = null;
            String videoInfo = null;
            if(commandLine.hasOption("platform") && commandLine.hasOption("video")){
                platform = commandLine.getOptionValue("platform");
                videoInfo = commandLine.getOptionValue("video");
            }else {
                throw new IncompleteParamException("ERROR: Please specify the platform name and video information, or see the detail for -h/--help");
            }
            if(commandLine.hasOption("user")){
                userName = commandLine.getOptionValue("user");
            }
            AppTrigger.getInstance().toUpload(platform, videoInfo, userName);

        }
    }
}
