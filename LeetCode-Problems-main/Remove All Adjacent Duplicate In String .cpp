class Solution {
public:
    string removeDuplicates(string s) {
        // Create an empty stack.
        stack<char> stack;

        // Iterate over the string
        for (char c : s) {
            // If stack has at least one character and
            // stack's top character is the same as the string's character.
            if (!stack.empty() && stack.top() == c) {
                // Pop a character from the stack.
                stack.pop();
            } else {
                // Otherwise, push that character onto the stack.
                stack.push(c);
            }
        }

        // Initialize a string to construct the result
        string result;
        // Pop all characters from the stack and append them to the result
        while (!stack.empty()) {
            result.push_back(stack.top());
            stack.pop();
        }

        // Since the characters were added in reverse order, 
        // reverse the result to get the final result
        reverse(result.begin(), result.end());
        return result;
    }
};
