package frontend.general;

import frontend.groups.test;
import Backend.Account.Account;
import Backend.Authentication.Register;
import Backend.Databases.Databases;
import Backend.Feed.Group;
import frontend.friends.FriendsManagement;
import frontend.groups.GroupPage;
import frontend.groups.GroupsManagement;
import frontend.settings.Settings;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    private Account acc;
    Databases Database = Databases.getInstance();

    public Home(Account acc) {
        initComponents();
        Database.read();
        this.setLocationRelativeTo(null);
        setResizable(false);
        this.acc = acc;

        DefaultListModel<String> newsFeedModel = new DefaultListModel<>(); // Initialize DefaultListModel
        for (int i = 0; i < Group.getGroups().size(); i++) {
            if (Group.getGroups().get(i).isMember(acc.getUsername()) || Group.getGroups().get(i).getCreator().getUsername().equals(acc.getUsername())) {
                String listItem = String.format("%s~%s", "Group", Group.getGroups().get(i).getName());
                newsFeedModel.addElement(listItem);
            }
        }

        for (int i = 0; i < acc.getFriendsManagement().getFriends().size(); i++) {
            String friendUsername = acc.getFriendsManagement().getFriends().get(i).getUsername();
            for (int j = 0; j < acc.getFriendsManagement().getFriends().get(i).getContentManagement().getContent().size(); j++) {
                // Extract content details
                String time = acc.getFriendsManagement().getFriends().get(i).getContentManagement().getContent().get(j).getTime().toString();
                String text = (String) acc.getFriendsManagement().getFriends().get(i).getContentManagement().getContent().get(j).getContentMap().get("Text");
                String path = (String) acc.getFriendsManagement().getFriends().get(i).getContentManagement().getContent().get(j).getContentMap().get("Path");
                // Format the data for display
                String listItem = String.format("%s~%s~%s~%s~%s", "Content", friendUsername, time, text != null ? text : "No Text", path != null ? path : "No Path");
                // Add the formatted string to the DefaultListModel
                newsFeedModel.addElement(listItem);
            }
        }
        newsFeed.setModel(newsFeedModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newsFeed = new javax.swing.JList<>();
        Friends = new javax.swing.JButton();
        Settings = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        Profile = new javax.swing.JButton();
        NewContent = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        View = new javax.swing.JButton();
        Groups = new javax.swing.JButton();
        Notifications = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        jLabel1.setText("CONNECT HUB");

        jScrollPane1.setViewportView(newsFeed);

        Friends.setText("Friends");
        Friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriendsActionPerformed(evt);
            }
        });

        Settings.setText("Settings");
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Profile.setText("Profile");
        Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileActionPerformed(evt);
            }
        });

        NewContent.setText("New content");
        NewContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewContentActionPerformed(evt);
            }
        });

        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        View.setBackground(new java.awt.Color(0, 204, 204));
        View.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        View.setText("VIEW");
        View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewActionPerformed(evt);
            }
        });

        Groups.setText("Groups");
        Groups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupsActionPerformed(evt);
            }
        });

        Notifications.setText("Notifications");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(Home)
                        .addGap(18, 18, 18)
                        .addComponent(Profile)
                        .addGap(18, 18, 18)
                        .addComponent(Friends)
                        .addGap(18, 18, 18)
                        .addComponent(Groups)
                        .addGap(18, 18, 18)
                        .addComponent(NewContent)
                        .addGap(18, 18, 18)
                        .addComponent(Notifications)
                        .addGap(18, 18, 18)
                        .addComponent(Settings)
                        .addGap(18, 18, 18)
                        .addComponent(LogOut)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(View)
                .addGap(416, 416, 416))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogOut)
                    .addComponent(Settings)
                    .addComponent(NewContent)
                    .addComponent(Friends)
                    .addComponent(Profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home)
                    .addComponent(jLabel1)
                    .addComponent(Groups)
                    .addComponent(Notifications))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(View)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileActionPerformed
        //GOES TO PROFILE
        MyProfile p = new MyProfile(acc);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ProfileActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Database.logoutDatabase(acc.getUsername());
    }//GEN-LAST:event_formWindowClosing

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewActionPerformed
        int i = newsFeed.getSelectedIndex();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Choose a content to view!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String line = newsFeed.getSelectedValue();
            String[] temp = line.split("~");
                if (temp[0].equals("Group")) {
                GroupPage gp = new GroupPage(acc, Database.getGroup(temp[1]));
                gp.setVisible(true);
                this.setVisible(false);
            }
            if (temp[0].equals("Content")) {
                DisplayContent c = new DisplayContent(acc, temp);
                c.setVisible(true);
            }
        }
    }//GEN-LAST:event_ViewActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        Database.logoutDatabase(acc.getUsername());
        this.setVisible(false);
        Startup window = new Startup();
        window.setVisible(true);
    }//GEN-LAST:event_LogOutActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        //GOES TO SETTINGS
        Settings s = new Settings(acc);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SettingsActionPerformed

    private void NewContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewContentActionPerformed
        //ADD NEW CONTENT
        AddContent c = new AddContent(acc);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_NewContentActionPerformed

    private void FriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriendsActionPerformed
        FriendsManagement f = new FriendsManagement(acc);
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_FriendsActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        //REFRESH AND GOES BACK TO HOME
        Database.read();
        Home home = new Home(acc);
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeActionPerformed

    private void GroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupsActionPerformed
        //GOES TO GROUPS
        Database.read();
        GroupsManagement g = new GroupsManagement(acc);
        g.setVisible(true);
        this.setVisible(false);
        ///////////////////////////////////////////////
        /*test t = new test(acc);
        t.setVisible(true);
        this.setVisible(false);*/
    }//GEN-LAST:event_GroupsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Friends;
    private javax.swing.JButton Groups;
    private javax.swing.JButton Home;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton NewContent;
    private javax.swing.JButton Notifications;
    private javax.swing.JButton Profile;
    private javax.swing.JButton Settings;
    private javax.swing.JButton View;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> newsFeed;
    // End of variables declaration//GEN-END:variables
}
