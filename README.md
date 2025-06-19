# 🌡️ThermoMate – Temperature Converter + AI Assistant
    ThermoMate is a user-friendly Java-based temperature converter with an integrated AI assistant chatbot. 
    It supports multi-format unit conversions, a secure email entry screen, and a logout feature for enhanced user flow.
    
## 🛠️ Tools & Technologies Used
    *Java (JDK 17+):Core language used for development
    *Swing (javax.swing):GUI development
    *AWT (java.awt):Component layout and colors
    *JOptionPane:Popup dialogs (AI assistant & alerts)
## 🧱 GUI Structure
    1️⃣ Email Input Screen (EmailScreen)
        🖊️ Input Field: Accepts user email.
        🔘 Button: Continue (validates email and opens main app).
        🎨 Dark-themed background with a branded title.

    2️⃣ Main Converter Dashboard (TemperatureConverter)
        🔄 Dropdowns: From and To unit selectors (Celsius, Kelvin, Fahrenheit, Reaumur, Rankine).
        ✍️ Input Field: Accepts temperature value.
        📤 Output Field: Displays converted value.
        🎯 Buttons:
                  ✅ Convert: Processes the conversion.
                  🤖 AI Assistant: Opens a chatbot popup.
                  🔒 Logout: Returns to email screen.

                  
## 🧠 AI Assistant (ChatBot)
      -Accessible via 🤖 AI Assistant button.
      -Built using JOptionPane for popup interaction.
      -Provides quick help instructions.

## 🔓 Logout Feature
      Button labeled Logout allows returning to the Email Entry screen.
      Logic:
            logoutBtn.addActionListener(e -> {
                  this.dispose();           // Close current window
                  new EmailScreen();        // Reopen Email screen
            });

## 💡 UX Features
        📧 Personalized dashboard showing user’s email.
        🚫 Error handling with messages for invalid input and email.
        🧼 Clear layout using null layout (manual setBounds() positioning).
        🎨 Color themes:
                        -EmailScreen: Dark blue background with white fonts.
                        -Main Screen: Light blue theme with blue and red button accents.

## Output Images:

![image alt](https://github.com/mushkaan0205/Temperature-converter-java-/blob/fcd226550e03174c57f8e196d6dcf22519e341c9/img/TC%20(1).png) 
![image alt](https://github.com/mushkaan0205/Temperature-converter-java-/blob/fcd226550e03174c57f8e196d6dcf22519e341c9/img/TC%20(2).png)
![image alt](https://github.com/mushkaan0205/Temperature-converter-java-/blob/fcd226550e03174c57f8e196d6dcf22519e341c9/img/TC%20(3).png)
![image alt](https://github.com/mushkaan0205/Temperature-converter-java-/blob/fcd226550e03174c57f8e196d6dcf22519e341c9/img/TC%20(4).png)
![image alt](https://github.com/mushkaan0205/Temperature-converter-java-/blob/fcd226550e03174c57f8e196d6dcf22519e341c9/img/TC%20(5).png)


