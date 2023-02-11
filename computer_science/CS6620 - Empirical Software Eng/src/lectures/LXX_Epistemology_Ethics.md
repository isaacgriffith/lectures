---
author:
- Isaac Griffith
title: Epistemology & Ethics
institute: |
  CS 6620 - Empirical Software Engineering

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outline

* Recap from last week
* Myths about science
* Epistemological Stances
* Qualitative, Quantitative & Mixed methods
* Brief overview of the philosophy of science
* Validity and reliability
* Research Ethics

# Myths about Science

* "It's just a theory"
  - Theory = "best explanation for the available evidence"
  - Overwhelming evidence doesn't stop it being a theory...
  - ...but lack of evidence does.

::: columns
:::: column

::::
:::: column
Examples:

We have a "law of gravity" ...but no "theory of gravity"

We have a "theory of evolution" ...but no "law of evolution"
::::
:::

# Myths about Science

* "Scientists follow the scientific method"
  - There is no one method
  - Many methods available...
  - ...and all of them have known flaws
  - Scientists use imagination, creativity, prior knowledge, perseverance...

* "Scientific knowledge is general and absolute"
  - Empirical Induction used to build evidence
  - Scientists often get it wrong
  - ...but Science (as a process) is self-correcting
  - All scientific laws and theories have limited scope
    * E.g. biological theories probably only apply on our own planet
    * E.g. laws of classical physics don't apply at the subatomic level

# Research Methods

* First step to **design** a research proposal: adopt a general (and guiding) **framework**

* Three frameworks (approaches to research): **Qualitative**, **Quantitative**, and **Mixed Methods**

* These approaches include:
  - **philosophical** assumptions (postpositivist, constructivist, emancipatory/critical, pragmatic)
  - strategies of **inquiry** (experimental, ethnographic, narrative, mixed methods design)
  - research **methods** (data collection and analysis)

# Discussion Questions

* How do you select a framework or approach?

* Examples of Qualitative, Quantitative, and Mixed Methods research in SE?

* Which of these approaches apply best in your own research?

# What will you accept as knowledge?

::: columns
:::: column

* Positivist (or "Post-positivist")
  - Knowledge is objective
  - "Causes determine effects/outcomes"
  - Reductionist: study complex things by breaking down to simpler ones
  - Prefer quantitative approaches
  - \color{Roarange}Verifying (or Falsifying) theories\color{Black}

* Critical Theorist
  - Research is a political act
  - Knowledge is created to empower groups/individuals
  - Choose what to research based on who it will help
  - Prefer participatory approaches
  - \color{Roarange}Seeking change in society\color{Black}

::::
:::: column

* Constructivist/Interpretivist
  - Knowledge is socially constructed
  - Truth is relative to context
  - Theoretical terms are open to interpretation
  - Prefer qualitative approaches
  - \color{Roarange}Generating "local" theories\color{Black}

* Eclectic/Pragmatist
  - Research is problem-centered
  - "All forms of inquiry are biased"
  - Truth is what works at the time
  - Prefer multiple methods / multiple perspectives
  - \color{Roarange}seeking practical solutions to problems\color{Black}

::::
:::

# Meta-theories (theories about theory)

::: columns
:::: column

* Logical Positivism:
  - Separates discovery from validation
  - Logical deduction, to link theoretical concepts to observable phenomena
  - Scientific truth is absolute, cumulative, and unifiable
* Popper:
  - Theories can be refuted, not proved;
  - Only falsifiable theories are scientific
* Campbell:
  - Theories are underdetermined
  - All observation is theory-laden, biased
* Quine:
  - Terms used in scientific theories have contingent meanings
  - Cannot separate theoretical terms from empirical findings
* Kuhn:
  - Science characterized by dominant paradigms, punctuated by revolution

::::
:::: column

* Lakatos:
  - Not one paradigm, but many competing research programmes
  - Each has a hard core of assumptions immune to refutation
* Feyerabend:
  - Cannot separate scientific discovery from its historical context
  - All scientific methods are limited
  - Any method offering new insight is ok
* Toulmin:
  - Evolving Weltanschauung determines what is counted as fact;
  - Scientific theories describe ideals, and explain deviations
* Laudan:
  - Negative evidence is not so significant in evaluating theories
  - All theories have empirical difficulties
  - New theories seldom explain everything the previous theory did

::::
:::

# Singer & Vinson

* Paper based on a series of vignettes
* Key ideas:
  - Informed Consent (participants' perceptions matter!)
  - Scientific Value (is the study worth doing?)
  - Beneficience (Do the benefits outweigh the risks?)
  - Confidentiality
  - Consent from creators of artifacts?
* Role of Ethics Review Board (or IRB)
* Ethical considerations needed before the study starts!

# Singer & Vinson - Discussion Questions

* What other codes of ethics apply (e.g. ACM?)
* How much detail do participants need about the study?
* How can we ensure confidentiality in the era of data mining?
* Is it ever ethical for course instructors to run controlled experiments on different pedagogical techniques?
* How important is it to share the results of your study with the participants?

# Research Ethics

* Reasons to take ethics seriously:
  - Funding depends on it
  - Relationship with research subjects/organizations depends on it
  - Legal issues (e.g. liability for harm to subjects/organizations)
  - Compliance with privacy and data protection laws
  - ...and it's the right thing to do!

* Institutional Review Boards (IRB)
  - Approval usually needed for all studies involving human subjects
  - Every IRB has it's own rules...
    * A study approved at one university may be disallowed at another!
    * Design of the study might have to be altered
  - Institutional research funding may depend on this process!
  - Note: guidelines from other fields may not apply to Software Engineering
    * E.g. use/ownership of source code
    * E.g. effect of process improvement on participants

# Informed Consent

* Elements
  - Disclosure - participants have full information about purpose, risks, benefits
  - Comprehension - jargon-free explanation, so participants can understand
  - Competence - participants must be able to make rational informed choice
  - Voluntariness - no coercion or undue influence to participate
  - Consent - usually indicated by signing a form
  - Right to withdraw
    * participant can withdraw from study at any point without having to give reasons
    - Participants can request their data to be excluded (might not be possible)

* Challenges:
  - Student participants
    * Perception that their grade will be affected if they don't participate
    * Perception that it will please the course instructor if they participate
  - Industrial participants
    * Perception that the boss/company wants them to participate

# An Ethical Dilemma...

You are dong a study of how junior analysts use new requirements tool at a leading
consultancy company. As part of informed consent, staff are informed that they will
remain anonymous. During the study, you notice that many of the analysts are making
data entry errors when logging time spent with clients. These errors are causing the
company to lose revenue. Company policy states clearly that workers salaries will be
docked for clear mistakes leading to loss of revenue.

Questions:

* Would you alter the results of your study to protect the people who help you in the study?
* How can you report results without causing harm to the participants?
* Would you cancel the study as soon as this conflict of interest is detected?

# Should you pay your participants?

* Arguments in favor
  - Can help with recruitment
  - Compensate participants for their time

* Arguments against
  - May induce participants to take risks they otherwise would not take
  - May get expensive (especially if rates are to be more than a token)

* Issues
  - IRB might have standard rate; might be too low for professional SE

* Alternatives:
  - All participants entered into draw for some new gadget

# Beneficence

* Risk of harm to Participants
  - Disrupts participant's work
  - Results of the research may devalue participants' work
  - Publication of study may harm the company's business

* Benefits of study
  - Scientific value: useful to society?
  - Depends on importance of the research topic!
  - Note: validity is crucial - invalid results means the study has no benefits
  - May also be specific benefits to participants
    - e.g. training, exposure to state-of-the art techniques, etc.

* Beneficence: Benefits should outweigh the risks
  - Understand and justify any tradeoffs in the design of the study

# Confidentiality

* Protecting Anonymity
  - Do not collect any data (e.g. names) that allow participants to be identified
  - But you need a signed consent form, so...
  - Sever participants' identify from their data before it is stored and analyzed
  - Researcher-subject interactions should be held in private

* Protecting the data
  - Consent form states who will have access to the data, and for what purpose
    - Do not stray from this!
  - Raw data should be kept in a secure location
  - Reports should only include aggregate data

* Exceptions:
  - When it is impossible to identify individuals from the raw data
  - When more harm results from maintaining confidentiality than breaching it
