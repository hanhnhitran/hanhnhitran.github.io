def get_greetings(name):
    if name != "":
        return "Greetings " + name + "! I am your virtual assistant Chat231."
    else:
        return "Hello there! I am your virtual assistant Chat231."

def is_whole_word(word, sentence):
    notations = ["!", ".", "?", ",", " "]
    word = word.lower()
    sentence = sentence.lower()

    if word not in sentence:
        return False

    index = sentence.index(word)
    if (index == 0 or sentence[index - 1] == " ") and (index + len(word) == len(sentence) or sentence[index + len(word)] in notations):
        return True
    else:
        return False

def get_answers(q_and_a, question):
    question = question.lower()
    for k, v in q_and_a.items():
        if k.lower() in question and is_whole_word(k, question):
            return v
    return "Sorry, I do not understand your question."