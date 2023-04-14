let currentSubPart = null;

// A recoder moi même
const switchSubPart = (newIdSubPartToDisplay, postSwitchTask) => {
  if (currentSubPart) currentSubPart.style.display = "none";
  currentSubPart = document.getElementById(newIdSubPartToDisplay);
  currentSubPart.style.display = "block";
  if (postSwitchTask) postSwitchTask();
};

window.onload = () => {
  switchSubPart("idWelcomeSubPart");
};
