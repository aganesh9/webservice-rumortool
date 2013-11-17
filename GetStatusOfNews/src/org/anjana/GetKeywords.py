import sys
import nltk

def main():
    myd = sys.argv[1]
    keywords = ""
    myd1 = myd.replace("/"," ")
    sentences = nltk.sent_tokenize(myd1)  
    sentences = [nltk.wordpunct_tokenize(sent) for sent in sentences]
    sentences = [nltk.pos_tag(sent) for sent in sentences]
    for sent in sentences:
        for word in sent:
            #Only words that are significant parts of speech are chosen as keywords
            if word[1] in ('JJ','NNP', 'NNS', 'NNPS', 'VB', 'VBD', 'VBG', 'WRB', 'NN'):
                keywords = keywords + word[0] + ":" + word[1] + "\n"
    print keywords

if __name__ == "__main__":
    main()



