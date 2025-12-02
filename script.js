// Responsive navbar toggle - robust version
document.addEventListener('DOMContentLoaded', () => {
    const hamburger = document.getElementById('hamburger');
    const navMenu = document.getElementById('navMenu');
    const navLinks = document.querySelectorAll('.nav-link');
  
    if (!hamburger || !navMenu) return;
  
    // open/close using max-height so transitions work reliably
    function openMenu() {
      hamburger.classList.add('active');
      const contentHeight = navMenu.scrollHeight; // actual height of ul
      navMenu.style.maxHeight = contentHeight + 'px';
      hamburger.setAttribute('aria-expanded', 'true');
    }
  
    function closeMenu() {
      hamburger.classList.remove('active');
      navMenu.style.maxHeight = '0';
      hamburger.setAttribute('aria-expanded', 'false');
    }
  
    hamburger.addEventListener('click', (e) => {
      e.stopPropagation();
      if (navMenu.style.maxHeight && navMenu.style.maxHeight !== '0px') {
        closeMenu();
      } else {
        openMenu();
      }
    });
  
    // Close when a nav link is clicked
    navLinks.forEach(link => {
      link.addEventListener('click', () => {
        closeMenu();
      });
    });
  
    // Click outside to close
    document.addEventListener('click', (e) => {
      const target = e.target;
      if (navMenu.style.maxHeight && navMenu.style.maxHeight !== '0px') {
        if (!navMenu.contains(target) && !hamburger.contains(target)) {
          closeMenu();
        }
      }
    });
  
    // Close on Escape
    document.addEventListener('keydown', (e) => {
      if (e.key === 'Escape') closeMenu();
    });
  
    // Reset inline style when resizing to desktop so nav shows normally
    window.addEventListener('resize', () => {
      if (window.innerWidth > 768) {
        navMenu.style.maxHeight = null; // allow CSS flex display
        hamburger.classList.remove('active');
        hamburger.setAttribute('aria-expanded', 'false');
      } else {
        // ensure hidden on small screens until user opens
        navMenu.style.maxHeight = '0';
      }
    });
  
    // ensure correct initial state
    if (window.innerWidth <= 768) navMenu.style.maxHeight = '0';
  });

// Chatbot functionality
document.addEventListener('DOMContentLoaded', function() {
    const chatbotToggle = document.getElementById('chatbotToggle');
    const chatbotWindow = document.getElementById('chatbotWindow');
    const chatbotClose = document.getElementById('chatbotClose');
    const chatbotInput = document.getElementById('chatbotInput');
    const chatbotSend = document.getElementById('chatbotSend');
    const chatbotMessages = document.getElementById('chatbotMessages');

    if (!chatbotToggle || !chatbotWindow) return;

    // Open chatbot
    chatbotToggle.addEventListener('click', function() {
        chatbotWindow.classList.add('active');
        chatbotInput.focus();
    });

    // Close chatbot
    if (chatbotClose) {
        chatbotClose.addEventListener('click', function() {
            chatbotWindow.classList.remove('active');
        });
    }

    // Chatbot responses
    const responses = {
        'hello': 'Hello! How can I help you today?',
        'hi': 'Hi there! How can I assist you?',
        'donate': 'You can donate by visiting our Donate page. We accept PayPal, Stripe, Flutterwave, and bank transfers. Every contribution helps transform lives!',
        'donation': 'You can donate by visiting our Donate page. We accept PayPal, Stripe, Flutterwave, and bank transfers. Every contribution helps transform lives!',
        'volunteer': 'We\'d love to have you as a volunteer! Visit our "Get Involved" page to learn more about volunteer opportunities.',
        'volunteering': 'We\'d love to have you as a volunteer! Visit our "Get Involved" page to learn more about volunteer opportunities.',
        'programs': 'We offer School Access Support, Learning Materials Drive, Mentorship & Tutoring, and Community Engagement programs. Visit our Programs page for details!',
        'program': 'We offer School Access Support, Learning Materials Drive, Mentorship & Tutoring, and Community Engagement programs. Visit our Programs page for details!',
        'contact': 'You can reach us at:\n- Phone: +2348031114594 or +1 (208) 992-6233\n- Email: michael@liftandservefoundation.com\n- Visit our Contact page for more options!',
        'email': 'You can email us at michael@liftandservefoundation.com or emmanuel@liftandservefoundation.com',
        'phone': 'You can call us at +2348031114594 (Nigeria) or +1 (208) 992-6233 (USA)',
        'about': 'Lift and Serve All Foundation is dedicated to transforming the lives of children in underserved communities through education. Visit our About page to learn more!',
        'mission': 'Our mission is to empower vulnerable communities through quality education for all, breaking the chains of poverty.',
        'vision': 'Our vision is to break the chains of poverty by ensuring access to quality education for every child.',
        'location': 'We are based in Accra, Ghana, and serve communities across multiple regions.',
        'address': 'We are based in Accra, Ghana, and serve communities across multiple regions.',
        'help': 'I can help you with information about donations, volunteering, programs, contact details, and more. What would you like to know?',
        'thanks': 'You\'re welcome! Is there anything else I can help you with?',
        'thank you': 'You\'re welcome! Is there anything else I can help you with?'
    };

    // Get bot response
    function getBotResponse(userMessage) {
        const lowerMessage = userMessage.toLowerCase().trim();
        
        // Check for keywords
        for (const [keyword, response] of Object.entries(responses)) {
            if (lowerMessage.includes(keyword)) {
                return response;
            }
        }
        
        // Default response
        return 'Thank you for your message! For more detailed information, please visit our website pages or contact us directly at michael@liftandservefoundation.com. How else can I help you?';
    }

    // Add message to chat
    function addMessage(text, isUser = false) {
        const messageDiv = document.createElement('div');
        messageDiv.className = `chatbot-message ${isUser ? 'user-message' : 'bot-message'}`;
        messageDiv.innerHTML = `<p>${text}</p>`;
        chatbotMessages.appendChild(messageDiv);
        chatbotMessages.scrollTop = chatbotMessages.scrollHeight;
    }

    // Send message
    function sendMessage() {
        const message = chatbotInput.value.trim();
        if (!message) return;

        addMessage(message, true);
        chatbotInput.value = '';

        // Simulate typing delay
        setTimeout(() => {
            const botResponse = getBotResponse(message);
            addMessage(botResponse, false);
        }, 500);
    }

    // Send button click
    if (chatbotSend) {
        chatbotSend.addEventListener('click', sendMessage);
    }

    // Enter key press
    if (chatbotInput) {
        chatbotInput.addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                sendMessage();
            }
        });
    }
});

// Function to open chatbot from other pages
function openChatbot() {
    const chatbotWindow = document.getElementById('chatbotWindow');
    const chatbotInput = document.getElementById('chatbotInput');
    if (chatbotWindow) {
        chatbotWindow.classList.add('active');
        if (chatbotInput) {
            setTimeout(() => chatbotInput.focus(), 100);
        }
    }
}
  