# Install Kubetcl


### Linux
https://kubernetes.io/docs/tasks/tools/install-kubectl/

```sh
sudo apt-get update && sudo apt-get install -y apt-transport-https
curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key add -
sudo touch /etc/apt/sources.list.d/kubernetes.list
echo "deb http://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee -a /etc/apt/sources.list.d/kubernetes.list
sudo apt-get update
sudo apt-get install -y kubectl
```

Config `~/.kube/config`

```bash
# autocomplexion
kubectl completion -h
```

## Mac

* [Install Macos](https://kubernetes.io/docs/tasks/tools/install-kubectl-macos/).

```sh
# with brew
brew install kubectl
```


## Check install
```bash
# display info
kubectl cluster-info
# see nodes
kubectl get nodes
# version
kubectl version
```

## Credit
https://kubernetes.io/docs/tutorials/kubernetes-basics/
